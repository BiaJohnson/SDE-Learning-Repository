# Grade Reader Program

## Description
This program processes student grade information from a TSV (Tab-Separated Values) file and generates a report with letter grades and exam averages.

## Features
- Reads student information from a TSV file containing:
    - Last Name
    - First Name
    - Midterm 1 Score
    - Midterm 2 Score
    - Final Exam Score
- Calculates letter grades based on the following scale:
    - A: 90 or above
    - B: 80-89
    - C: 70-79
    - D: 60-69
    - F: below 60
- Generates a report.txt file containing:
    - Student information with calculated letter grades
    - Average scores for each exam

## Output Format
The program generates a report.txt file with:
- One student per row with tab-separated values:
    - Last Name
    - First Name
    - Midterm 1 Score
    - Midterm 2 Score
    - Final Exam Score
    - Letter Grade
- Exam averages with two decimal places of precision

## Example
Input file (StudentInfo.tsv):

```
Barrett Edan 70 45 59
Bradshaw Reagan 96 97 88
Charlton Caius 73 94 80
Mayo Tyrese 88 61 36
Stern Brenda 90 86 45
```

Output file (report.txt):

```
Barrett Edan 70 45 59 F
Bradshaw Reagan 96 97 88 A
Charlton Caius 73 94 80 B
Mayo Tyrese 88 61 36 D
Stern Brenda 90 86 45 C

Averages: Midterm1 83.40, Midterm2 76.60, Final 61.60
```
## Error Handling
The program includes error handling for:
- Missing input file
- Incorrect file format
- Invalid grade values
- Missing data fields

## Usage
1. Ensure your input file is in TSV format
2. Run the program with your input file
3. Check the generated report.txt file for results

