# AI Pathfinding Visualizer (Java)

This project demonstrates classical pathfinding algorithms used in robotics
and navigation systems.

Algorithms Implemented
- Breadth First Search (BFS)
- Dijkstra's Algorithm
- A* Search Algorithm

Features
- Random grid generation
- Obstacles simulation
- Shortest path discovery
- Node exploration comparison

Example Output
BFS explored: 87 nodes
Dijkstra explored: 87 nodes
A* explored: 71 nodes

Technologies
Java, Data Structures, Graph Algorithms

🟩 Start
🟥 Goal
⬛ Wall
🟨 Path

Symbols used in the grid:

S → Start node  
G → Goal node  
. → Empty traversable cell  
# → Obstacle / wall  
* → Path found by the algorithm  
v → Visited nodes during exploration

Output :

Generated Grid:
S . . . . . # # . . 
. . . . . # . # . . 
# . . . . . . # . . 
. . . . . . . . . . 
. . . . . # . . . # 
. . . # . . . . . # 
. . . . . . # . # . 
. . . . . . # . . # 
. # . # . # . . . . 
. . . . . . . . . G 

Running BFS...
Goal reached using BFS!
BFS explored: 82 nodes
Path:
S . . . . . # # . . 
* * . . . # . # . . 
# * . . . . . # . . 
. * . . . . . . . . 
. * . . . # . . . # 
. * . # . . . . . # 
. * . . . . # . # . 
. * * . . . # . . # 
. # * # . # . . . . 
. . * * * * * * * G

Running Dijkstra...
Goal reached using Dijkstra!
Dijkstra explored: 82 nodes
Path:
S . . . . . # # . .
* * * * . # . # . .
# * . * * * . # . .
. * . . . * * * . .
. * . . . # . * . #
. * . # . . . * . #
. * . . . . # * # .
. * * . . . # * . #
. # * # . # . * . .
. . * * * * * * * G

Running A*...
Goal reached using A*!
A* explored: 57 nodes
S * . . . . # # . .
* * * * . # . # . .
# * * * * * . # . .
. * . * * * * * . .
. * . . * # . * . #
. * . # * * * * . #
. * . . . . # * # .
. * * . . . # * * #
. # * # . # . * * *
. . * * * * * * * G

Algorithm Comparison:
BFS nodes explored: 82
Dijkstra nodes explored: 82
A* nodes explored: 57

