# Submission

Fork: https://github.com/Scraylex/WAS-exercise-9

## Task 1)

Sensing Agent 1 is the most trustworthy using a arithmetic mean trust calculation.

Side Note: Jacomo string equals is non existent weirdly enough??? Works in Java ¯_(ツ)_/¯

## Task 2)

Well the rogues now follow the leader. Wondering if we could do this in some dynamic way. May be a rogue organization I would guess. That could be a pretty interesting idea!
Since we did not change our trust mechanics sensing agent 1 is still the one picked.

## Task 3)

The rogue agents are all distrusted so in my implementation, as the "good" agents all have the same trust value and the amount of previous trust the agent in position 1 which is sensing agent 1 is still the one picked.

## Task 5)

First of all the truthful agents still win because the truth will always win!

Still there would be multiple ways for the rogues to win:

- The rogues could elect another rogue leader with a higher certification trust like sensing_agent 8.
- If the trust calculation would be done in another way that would also affect the outcome. If the for example the witnesses become higher rated and the certification gets lower weighted that would be a good thing for the rogues, because they are superior in numbers.
- If the good agents had no knowledge of who the rogues are and would assess them indifferently with a 0
- If simply even more rogues could join the organization
- If the rogues could vote the truthful agents out
- The rogues could attempt a Whitewashing strategy to act non malicious until they have accumulated enough reputation
- The rogues could attempt a Sybil attack impersonating new uncertified and "clean" agents pretending to be good agents
- The rogues could pretend to be the good agents to lower their reputations resulting in a ballot stuffing attack
- The rogue leader could launch a dynamic personality attack building up reputation until he starts to act malicious

Accordingly the acting agent should take certain precautions:

- requiring a certification of agents
- requiring a buildup of trust before one is elible to get picked
- make trust hard to gain and quick to lose
- limit the organizations size and make it costly to be added to the system