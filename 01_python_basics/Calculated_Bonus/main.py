import itertools #to create the iterator

def calculate(billable):

    bonus = [
         {"range":range(0,33), "bonus": 0},
         {"range":range(33,41), "bonus": 325},
         {"range":range(41,49), "bonus": 550},
         {"range":itertools.count(48), "bonus": 600}  #creates an iterator starting at 48. The count() function will continue counting indefinitely.
        ]
    
    incentive_payment = 0 #to hold the total incentive payment.
    count=0  #iterator for the while loop.
    
    '''
    for loop to iterate through the list, then if billable is found in the value range, do:
         1. if the range is found in the first element (first loop), where i=0, then subtract billable minus the last value of the range, to get the difference.
         2. Othewise, subtract billable minus the last value of the prior range (i-1) to get the difference.
         3. calculate the first incentive payment: the bonus associated to the day * the difference.
         4. while loop to do the calculation progressively, where d decrements to go "up" the list.
    '''

    for i in range(len(bonus)):
        if billable in bonus[i]["range"]:
            if i==0:
                difference = billable - bonus[i]["range"][-1]
            else:
                difference = billable - bonus[i-1]["range"][-1]
            incentive_payment = difference * bonus[i]["bonus"]
            d=i    #to hold the decrement, so the calculation happens progressively.                           
            while count < i - 1:
                difference = bonus[d-1]["range"][-1] - bonus[d-2]["range"][-1]  
                incentive_payment += difference * bonus[d-1]["bonus"]
                count+=1
                d-=1  
            break

    return incentive_payment 
 
def main():

    '''Try/catch in case the user enters an invalid response. ex: non integeter or empty responses.
       Ask user if he/she/they want to check incentive payment for another billable day amount:
        . if yes, then prompt the user to enter the billable days again and call function to calculate the incentive.
        . otherwise, end program.
    
    '''

    while True:
        try:
            billable_days = int(input("Please, enter the total billable days here to see your incentive payment: "))
            bonus= calculate(billable_days)  #call function to calculate the incentive
            print("The total incentive payment for {} billable days is: ${}" .format(billable_days,bonus))
            while True:
                another = input("Do you want to check the incentive payment for another billable day amount? (yes/no): ").strip().lower()
                if another not in ("yes", "no"):
                    print("Invalid input. Please answer with: yes/no.")
                    continue
                else:
                    break
            if another == "no":
                print("Thank you!")
                break
            
        except ValueError as e:
            print("invalid input. Please enter a whole number.")

if __name__== "__main__":
        main()
