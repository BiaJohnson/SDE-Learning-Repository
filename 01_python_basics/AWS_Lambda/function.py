import json
import boto3 #to interact with aws services
import io
from io import StringIO
import pandas as pd #to read

s3_client = boto3.client('s3')
def lambda_handler(event, context):
  try:
    # Get the S3 bucket and object key from the Lambda event trigger
    s3_Bucket_Name = event["Records"][0]["s3"]["bucket"]["name"]
    s3_File_Name = event["Records"][0]["s3"]["object"]["key"]

    object = s3_client.get_object(Bucket=s3_Bucket_Name, Key=s3_File_Name)
    body = object['Body']

    csv_string = body.read().decode('utf-8') #decoding
    dataframe = pd.read_csv(StringIO(csv_string)) #read content using pandas
    #print the data in csv file
    print(dataframe.head(4))

    #the below calculates final grade, where:
    #Assignment has weight = 20
    #Project has weight = 35
    #test has weight = 45
    final_grade = (dataframe['assignment']*0.2) + (dataframe['project']*0.35) + (dataframe['test']*0.45)

    for i in range(len(final_grade -1)):
    # for student in dataframe['student']:
      if final_grade[i] < 50:
        print("Student {}'s final grade is: {} and he/she failed" .format(dataframe.at[i,'student'], final_grade[i]))
      else:
        print("Student {}'s final grade is: {} and he/she passed" .format(dataframe.at[i,'student'], final_grade[i]))

  except Exception as err:
    print(err)

# TODO implement
  return {
    'statusCode': 200,
    'body': json.dumps('Hello from Lambda!')
}
