# AWS Lambda — Student Grade Processor

## Overview

A serverless AWS Lambda function triggered by S3 uploads that reads student grade CSV files, calculates weighted final grades, and determines pass/fail outcomes. Demonstrates event-driven cloud architecture integrating S3, Lambda, and pandas for data processing.

## Skills Demonstrated

- AWS Lambda event handling (S3 trigger)
- boto3 S3 client integration
- CSV parsing with pandas
- Weighted grade calculation logic
- Serverless pipeline design

## Tech Stack

- Python 3
- AWS Lambda, S3
- boto3, pandas

## How to Run

This function is designed for AWS Lambda deployment, not local CLI execution.

1. Package `function.py` with dependencies (`boto3`, `pandas`) as a Lambda deployment bundle.
2. Create an S3 bucket and configure an event notification to trigger the Lambda on `.csv` uploads.
3. Upload a CSV with columns: `student`, `assignment`, `project`, `test`.
4. Check CloudWatch Logs for grade calculations and pass/fail output.

**Expected CSV format:**

```csv
student,assignment,project,test
Alice,80,75,90
Bob,40,35,45
```

**Grade weights:** assignment 20%, project 35%, test 45%. Pass threshold: 50.

## Highlights

- Event-driven architecture: file upload automatically triggers processing
- Combines cloud services (S3 + Lambda) with data analysis (pandas)
