# agent-decision-making
University assignment part of CZ4046 Intelligent Agents course.

Environment:

![](maze_env.PNG?raw=true)

The  transition  model  is  as  follows:  the  intended  outcome  occurs  with  probability  0.8,  and with  probability  0.1  the  agent  moves  at  either  right  angle  to  the  intended  direction.  If  the 
move would make the agent walk into a wall, the agent stays in the same p
lace as before. The rewards  for  the  white  squares  are 0.04, for  the  green  squares  are  +1,  and  for  the  brown 
squares are 1. Note that there are no terminal states; the agent’s state sequence is infinite.

The goal is to find the optimal policy and utilities of all states (except the wall states) using:
* value iteration
* policy evaluation
