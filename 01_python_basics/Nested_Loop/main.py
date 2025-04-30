def rare_sum(lower_limit, upper_limit):
    """
    Prints the sum of all even and odd number pairs within a given range.

    Parameters:
    - lower_limit: The starting number of the range (expected as a string but converted to int).
    - upper_limit: The ending number of the range (expected as a string but converted to int).

    Raises:
    - TypeError: If inputs cannot be converted to integers.
    - ValueError: If limits are negative or invalid.
    """

    try:
        lower_limit = int(lower_limit)
        upper_limit = int(upper_limit)
    except ValueError:
        raise TypeError("Both limits must be valid integers.")

    if lower_limit < 0 or upper_limit < 0:
        raise ValueError("Numbers should be positive.")

    if lower_limit >= upper_limit:
        raise ValueError("Lower limit must be smaller than upper limit.")


    if lower_limit % 2:
        for even in range(lower_limit + 1, upper_limit, 2):  # Generate even numbers
            for odd in range(lower_limit, upper_limit, 2):  # Generate odd numbers
                print(f"{even} + {odd} = {even + odd}")
    else:
        for even in range(lower_limit, upper_limit, 2):  # Generate even numbers
            for odd in range(lower_limit + 1, upper_limit, 2):  # Generate odd numbers
                print(f"{even} + {odd} = {even + odd}")

# Keep asking for input until the user enters valid numbers
if __name__ == "__main__":
    print("Example: 5 to 15")
    rare_sum(5, 15)
    while True:
        try:
            lower = input("Enter the lower limit: ")
            upper = input("Enter the upper limit: ")
            rare_sum(lower, upper)
            break  # Exit the loop if no errors occur
        except (TypeError, ValueError) as e:
            print(f"Error: {e}. Please try again.")
