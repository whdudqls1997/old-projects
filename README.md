# Old Projects

## 01. Cheating Monitor

This program was created as a simple way to detect, and remove cheaters from our 10,000+ user discord server.
There were **way too many** cheaters, who disguised themselves as proficient players, in in-house tournaments.
To restore the integrity of the tournaments, this program was created.

###### Some side note
The program uses screenhook and process list monitoring to actively send user data towards an admin email. Since the
program deals with sensitive personal data, there is a prompt at launch stating the risks and limits of this program and
also the promise to discard data as soon as it's reviewed. Although somewhat unethical, using screenhook was the only way
to find the cheaters, as their "hacks" would often mask their screencapture with an unmodified version. Also thought of
ways to automate via a comparing algorithm between the person's screencapture and screenhook results, but certain overlays
(such as discord overlay) made false positive brutaly easy, so that option was discarded.

## 02. Maplestory Homework Tracker

This program was created to help friends get into the online MMORPG, Maplestory.
Simplistic UI with a feature to select tasks onto the program, much like a caldendar.
Automatically resets progress when the game's daily progression is reset (pulling from UDT).

## 03. Maplestory Stat Calculator

This program finds the ideal state of stat distribution in the online MMORPG, Maplestory.
Stat distribution is vital for min-maxing damage output, thus an all-in-one calculator that accepts
the current distribution, and suggests changes for best result, is vital.

## 04. Webparser Automation

This was an approach to automatically read website data, using JSoup and other plugins, in an attempt to
automate certain functions. Original idea was to use this template to automate class signups for college, but couldn't figure out
how to bypass the refresh rate limit. Tried to detect changes in the html document, which would trigger the automation, but
the amount of data to be compared was too broad (even when parsing most of the website), resulting in unsatisfactory runtimes.

## 05. Mouse Automation

Realistic mouse movement automation was somewhat of a personal challenge.
Wanted to figure out how to hook into the mouse hardware to make it seem like its the real movement (not like .robot class).
(This is nothing to be proud of) but the program's realistic mouse simulation seemed authentic enough to go undetected
by certain anti-automation softwares!

## 06. Hexagon game

This project was an attempt in creating an online game based on a hexagonal grid.
Now, hexagons are awesome, and a hexagonal grid seemed like a really good way to host up to 6 players, battle-royal style game.
The game itself was thought after the famous "Clash Royal" mobile game, but on a more complex structure (like that of Starcraft) and on a hexagonal grid.