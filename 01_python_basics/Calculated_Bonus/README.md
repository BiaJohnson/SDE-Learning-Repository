# Calculated Bonus — Progressive Incentive Calculator

## Overview

A Python program that calculates quarterly incentive bonuses for employees based on billable man-days. Uses a progressive rate scheme where bonus amounts increase as employees exceed a 32-day threshold.

## Skills Demonstrated

- Progressive tiered calculations
- Conditional logic and range-based pricing
- Function design with return values
- Practical business logic modeling

## Tech Stack

- Python 3

## How to Run

```bash
cd 01_python_basics/Calculated_Bonus
python main.py
```

## Highlights

- Progressive bonus rates apply to specific day ranges beyond the threshold:

| Billable Days | Bonus Rate |
|---------------|------------|
| 0–32 | $0 per day |
| 33–40 | $325 per day |
| 41–48 | $550 per day |
| > 48 | $600 per day |

- Example: 45 billable days → (8 × $325) + (5 × $550) = **$5,350**
