"""
Problem Statement for EllysViewPoints
Problem Statement
    Elly has a rectangular matrix with N rows and M columns. Each of the cells in the matrix can be either blocked (denoted '#') or free (denoted '.').
	An empty cell is called a view point if we can see outside the matrix when looking directly in each of the four cardinal directions: north, south, east, and west.
	In other words, a cell C is a view point if and only if all cells in those four directions from cell C are free.
	Below is an example matrix that contains six view points. One of these is marked by an asterisk ('*').

..#......
.....*...
.###..#..
.#.##..#.
...#..#..
.........

	The girl has given you the ints N and M, as well as the String[] matrix. Return the number of view points in the given matrix.

Definition
Class:	EllysViewPoints
Method:	getCount
Parameters:	int, int, String[]
Returns:	int
Method signature:	int getCount(int N, int M, String[] matrix)
(be sure your method is public)

Constraints
-	N will be between 1 and 50, inclusive.
-	M will be between 1 and 50, inclusive.
-	matrix will contain exactly N elements.
-	Each element of matrix will contain exactly M characters.
-	Each character in matrix will be either '#' or '.'.

Examples
0)	6
9
{"..#......",
 ".........",
 ".###..#..",
 ".#.##..#.",
 "...#..#..",
 "........."}
Returns: 6
The example from the problem statement.

1)
1
1
{"."}
Returns: 1
It's pretty obvious which cell is the view point.

2)
7
4
{"####",
 "####",
 "####",
 "####",
 "####",
 "####",
 "####"}
Returns: 0
With everything blocked, there are obviously no view points.

3)
9
48
{"#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.",
 "................................................",
 ".#####...###...###.......##....###....##..#####.",
 "...#....#.....#...#.....#..#..#...#..#.#..#...#.",
 "...#....#.....#...#........#..#...#....#..#####.",
 "...#....#.....#...#......#....#...#....#......#.",
 "...#.....###...###......####...###.....#..#####.",
 "................................................",
 "#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#."}
Returns: 18
Good luck!
"""
def getCount(N, M, matrix) :
    if len(matrix)==1 and '#' not in matrix[0] :
        return len(matrix[0])
    elif len(matrix)==1 and '#' in matrix[0] :
        return 0
    else :
        viewPoints = 0
        for i in range(len(matrix)) :
            if '#' not in matrix[i] :
                for k in range(len(matrix[i])) :
                    verticalLine = ""
                    for j in range(N) :
                        verticalLine = verticalLine + matrix[j][k]
                    if '#' not in verticalLine :
                        viewPoints = viewPoints + 1
        return viewPoints

print(getCount(6, 9, ["..#......", ".........", ".###..#..", ".#.##..#.", "...#..#..", "........."]))
print(getCount(48, 2, ["..", ".#", "..", "..", "#.", ".#", "..", "..", "#.", "#.", "..", "..", ".#", ".#", "##", "#.", "..", "#.", ".#", "..", ".#", "##", "#.", "#.", "..", "..", "..", "..", "..", "..", "#.", "##", ".#", "..", "##", ".#", "##", "#.", "##", "#.", ".#", "..", "..", "#.", "..", "#.", "##", ".#"]))
