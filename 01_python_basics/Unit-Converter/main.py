def convert(value, conversion_factors):
    """
    Converts a numerical value using predefined conversion factors.

    Parameters:
    value (str): The numerical value to be converted. If a string is passed,
                               it will be converted to a number if valid.
    conversion_factors (dict): A dictionary where keys represent target units
                               and values are the respective conversion factors.

    Returns:
    dict: A dictionary containing the converted values for each unit.

    Raises:
    TypeError: If the input is not a valid number.
    ValueError: If the input is negative.
    """
    # Attempt to convert a string input into a float
    try:
        value = float(value)
    except (ValueError, TypeError):
        raise TypeError("Input must be a valid number.")
    # Validate negative numbers
    if value < 0:
        raise ValueError("Negative values are not allowed.")

    # Perform unit conversion
    return {unit: value * factor for unit, factor in conversion_factors.items()}


# ---------------------- Weight Conversions ----------------------


def convert_kg(value):
    """
    Convert kilograms to ounces and pounds.

    Parameters:
    value (float): Value in kilograms.

    Returns:
    dict: Equivalent values in ounces and pounds.
    """
    return convert(value, {"ounces": 35.274, "pounds": 2.20462})


def convert_pounds(value):
    """
    Convert pounds to kilograms and ounces.

    Parameters:
    value (float): Value in pounds.

    Returns:
    dict: Equivalent values in kilograms and ounces.
    """
    return convert(value, {"kilograms": 0.453592, "ounces": 16})


def convert_ounces(value):
    """
    Convert ounces to kilograms and pounds.

    Parameters:
    value (float): Value in ounces.

    Returns:
    dict: Equivalent values in kilograms and pounds.
    """
    return convert(value, {"kilograms": 0.0283495, "pounds": 0.0625})


# ---------------------- Liquid Conversions ----------------------


def convert_liters(value):
    """
    Convert liters to fluid ounces, pints, and quarts.

    Parameters:
    value (float): Value in liters.

    Returns:
    dict: Equivalent values in fluid ounces, pints, and quarts.
    """
    return convert(value, {"fluid_ounces": 33.814, "pints": 2.11338, "quarts": 1.05669})


def convert_fluid_ounces(value):
    """
    Convert fluid ounces to liters, pints, and quarts.

    Parameters:
    value (float): Value in fluid ounces.

    Returns:
    dict: Equivalent values in liters, pints, and quarts.
    """
    return convert(value, {"liters": 0.0295735, "pints": 0.0625, "quarts": 0.03125})


def convert_pints(value):
    """
    Convert pints to liters, fluid ounces, and quarts.

    Parameters:
    value (float): Value in pints.

    Returns:
    dict: Equivalent values in liters, fluid ounces, and quarts.
    """
    return convert(value, {"liters": 0.473176, "fluid_ounces": 16, "quarts": 0.5})


def convert_quarts(value):
    """
    Convert quarts to liters, fluid ounces, and pints.

    Parameters:
    value (float): Value in quarts.

    Returns:
    dict: Equivalent values in liters, fluid ounces, and pints.
    """
    return convert(value, {"liters": 0.946353, "fluid_ounces": 32, "pints": 2})


# ---------------------- Testing & Execution ----------------------

if __name__ == "__main__":
    while True:
        try:
            v = input("Enter a weight value: ")
            print("-" * 40)
            print(f"The conversions for {v} kg are: {convert_kg(v)}")
            print(f"The conversions for {v} pounds are: {convert_pounds(v)}")
            print(f"The conversions for {v} ounces are: {convert_ounces(v)}")
            print("-" * 40)
            print(f"The conversions for {v} liters are: {convert_liters(v)}")
            print(
                f"The conversions for {v} fluid ounces are: {convert_fluid_ounces(v)}"
            )
            print(f"The conversions for {v} pints are: {convert_pints(v)}")
            print(f"The conversions for {v} quarts are: {convert_quarts(v)}")
            print("-" * 40)
            break
        except TypeError as e:
            print(f"TypeError: {e}")
        except ValueError as e:
            print(f"ValueError: {e}")
