"""
Problem Statement for LengthUnitCalculator
Problem Statement
    	Your task is to write a calculator that will convert between four different length units: inches (in), feet (ft), yards (yd), and miles (mi).
		The conversions between these units:
			1 ft = 12 in
			1 yd = 3 ft
			1 mi = 1760 yd
		You are given an int amount and Strings fromUnit and toUnit. Compute and return the amount of toUnits that corresponds to amount fromUnits.
		(For example, if amount=41, fromUnit="mi", and toUnit="in", you are supposed to compute the number of inches in 41 miles.)
		Note that the result will not necessarily be an integer.

Definition
Class:	LengthUnitCalculator
Method:	calc
Parameters:	int, String, String
Returns:	double
Method signature:	double calc(int amount, String fromUnit, String toUnit)
(be sure your method is public)

Notes
-	Pay attention to the unusual time limit.

Constraints
-	amount will be between 1 and 1,000, inclusive.
-	fromUnit will be one of {"in", "ft", "yd", "mi"}.
-	toUnit will be one of {"in", "ft", "yd", "mi"}.

Examples
0)	1
"mi"
"ft"
Returns: 5280.0
We are asked to convert 1 mile into feet. From the information in the statement we know that 1 mi = 1760 yd = (1760 * 3) ft = 5280 ft.

1)	1
"ft"
"mi"
Returns: 1.893939393939394E-4
Here we have 1 ft = 1/5280 mi, which is approximately 0.000189394 miles.

2)	123
"ft"
"yd"
Returns: 41.0

3)	1000
"mi"
"in"
Returns: 6.336E7

4)	1
"in"
"mi"
Returns: 1.5782828282828283E-5

5)	47
"mi"
"mi"
Returns: 47.0
"""
def calc(amount, fromUnit, toUnit) :
    totalConversionUnits = 0.0
    units = ["in", "ft", "yd", "mi"]
    unitsValue = {"miyd":1760.0, "mift":5280.0, "miin":63360.0, "ydft":3.0, "ydin":36.0, "ftin":12.0}
    if fromUnit==toUnit :
        totalConversionUnits = amount * 1.0
    elif units.index(fromUnit) > units.index(toUnit) :
        totalConversionUnits = amount * unitsValue[fromUnit+toUnit]
    elif units.index(fromUnit) < units.index(toUnit) :
        totalConversionUnits = amount / unitsValue[toUnit+fromUnit]
    return totalConversionUnits

print(calc(1, "mi", "ft"));
print(calc(1, "ft", "mi"));
print(calc(123, "ft", "yd"));
print(calc(1000, "mi", "in"));
print(calc(1, "in", "mi"));
print(calc(47, "mi", "mi"));
