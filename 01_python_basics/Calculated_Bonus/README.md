# Calculated-Bonus

## Overview
This Python program calculates the **quarterly incentive bonus** for employees of a financial institution based on the number of **billable man-days** provided. The organization incentivizes employees to exceed a set threshold of billable days by awarding a **progressively increasing bonus** based on the number of extra days worked.

## Objective
Prompt the user to enter the number of **billable days** for the quarter.
Calculate the bonus according to a progressive scheme.
Return and display the total bonus amount.

## Bonus Scheme
The incentive is calculated **progressively**, meaning different bonus rates apply to specific ranges of extra days beyond the 32-day threshold.
| Billable Days         | Bonus Rate              |
|-----------------------|-------------------------|
| 0 to 32               | $0 per day              |
| 33 to 40              | $325 per day            |
| 41 to 48              | $550 per day            |
| Greater than 48       | $600 per day            |

### Example Calculation

For **45 billable days**, the bonus is calculated as:
First 32 days: no bonus
Next 8 days (33–40): 8 × $325 = $2,600 
Next 5 days (41–45): 5 × $550 = $2,750 
*Total Bonus = $2,600 + $2,750 = $5,350

## Examples
```python
bonus(15) ➞ 0
bonus(37) ➞ 1625
bonus(50) ➞ 8200*
```

## Skills Demonstrated

-	Conditional logic and progressive calculations
-	User input handling (optional)
-	Function creation and return values
- Practical application of incentive logic
