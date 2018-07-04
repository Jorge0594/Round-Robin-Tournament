# Round-Robin-Tournament
A simple program to create a tournament schedule using Round-robin algorithm

## How it works

This algorithm is based on construction of pairing tables by Richard Schurig provides a simple way to match the tournament teams. All you need is to generate two like the ones shown below:

For 7 or 8 players, Schurig builds a table with `n / 2` colums and `n - 1`, as follows(Note: Always select the next pair number if the number of players is odd):

|  Rounds   | Match 1 | Match 2 | Match 3 | Match 4 |
| --------- | ------- | ------- | ------- | ------- |
|  Round 1  |    1    |    2    |    3    |    4    |
|  Round 2  |    5    |    6    |    7    |    1    |
|  Round 3  |    2    |    3    |    4    |    5    |
|  Round 4  |    6    |    7    |    1    |    2    |
|  Round 5  |    3    |    4    |    5    |    6    |
|  Round 6  |    7    |    1    |    2    |    3    |
|  Round 7  |    4    |    5    |    6    |    7    |

The second table is constructed as shown bellow:

|  Rounds   | Match 1 | Match 2 | Match 3 | Match 4 |
| --------- | ------- | ------- | ------- | ------- |
|  Round 1  |    8    |    7    |    6    |    5    |
|  Round 2  |    8    |    4    |    3    |    2    |
|  Round 3  |    8    |    1    |    7    |    6    |
|  Round 4  |    8    |    5    |    4    |    3    |
|  Round 5  |    8    |    2    |    1    |    7    |
|  Round 6  |    8    |    6    |    5    |    4    |
|  Round 7  |    8    |    3    |    2    |    1    |

If the tournament have a odd number of players the matches that contain the number 8 will be ignored.

And finally, merge the tables:

|  Rounds   | Match 1 | Match 2 | Match 3 | Match 4 |
| --------- | ------- | ------- | ------- | ------- |
|  Round 1  |  1 - 8  |    2    |    3    |    4    |
|  Round 2  |  8 - 5  |    6    |    7    |    1    |
|  Round 3  |  2 - 8  |    3    |    4    |    5    |
|  Round 4  |  8 - 6  |    7    |    1    |    2    |
|  Round 5  |  3 - 8  |    4    |    5    |    6    |
|  Round 6  |  8 - 7  |    1    |    2    |    3    |
|  Round 7  |  4 - 8  |    5    |    6    |    7    |

If the number of players is pair, the last num (in this case the 8) writes alternately from right to left. Otherwise simply ignore this column.

For the others columns the table as shown bellow:

|  Rounds   | Match 1 | Match 2 | Match 3 | Match 4 |
| --------- | ------- | ------- | ------- | ------- |
|  Round 1  |  1 - 8  |  2 - 7  |  3 - 6  |  4 - 5  |
|  Round 2  |  8 - 5  |  6 - 4  |  7 - 3  |  1 - 2  |
|  Round 3  |  2 - 8  |  3 - 1  |  4 - 7  |  5 - 6  |
|  Round 4  |  8 - 6  |  7 - 5  |  1 - 4  |  2 - 3  |
|  Round 5  |  3 - 8  |  4 - 2  |  5 - 1  |  6 - 7  |
|  Round 6  |  8 - 7  |  1 - 6  |  2 - 5  |  3 - 4  |
|  Round 7  |  4 - 8  |  5 - 3  |  6 - 2  |  7 - 1  |



