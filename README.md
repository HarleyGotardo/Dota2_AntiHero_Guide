# Dota2 Anti-Hero Guide Expert System

## Introduction

The Dota2 Anti-Hero Guide Expert System is a simple tool designed to provide recommendations for possible anti-heroes based on user input. It is intended to assist Dota 2 players in countering specific heroes during draft pick phases. This expert system offers two modes of operation:

1. **All possible Anti-Hero recommendations:** In this mode, the system will ask for a Dota 2 hero's name as input and return a list of anti-heroes that can effectively combat the input hero.

2. **Filtered Anti-Hero recommendations:** In this mode, the system will request the Dota 2 hero's name and the desired attribute and role of the anti-hero to counter the input hero.

## System Overview

### Model

This expert system is implemented using Object Attribute Based Searching and String Search and Manipulation. It follows an object-oriented programming approach using the Java programming language.

### Classes

- **Hero:** Contains the blueprint for a Dota 2 hero, including attributes such as name, attribute, roles, and a list of heroes they are good against.
- **HeroDatabase:** Manages the instantiation of Hero classes and stores an array of Hero objects.
- **Role:** An enum that defines the various roles of Dota 2 heroes.
- **Attribute:** An enum that defines the attributes of Dota 2 heroes.
- **AntiHeroGuide:** Contains the main function and algorithm for the expert system.

### Hero Attributes

A Dota 2 hero is represented by the following attributes:

- **Name**
- **Attribute**
- **Role[]:** An array of roles the hero can play.
- **String[] goodAgainst:** A list of heroes that the hero is effective against and also the description of the reason.

## Inference Algorithm

The `counterHero` function is responsible for finding possible anti-heroes for the inputted Dota 2 hero. It follows these steps:

1. Initialize a boolean variable `foundAntiHero` as `false`.

2. Iterate through the list of heroes in the `heroes` array.

3. For each hero, retrieve their `goodAgainst` list.

4. Check if the hero's `MainAttribute` matches the input `attribute`. If not, skip to the next hero.

5. Check if the hero has the specified `role`. If not, skip to the next hero.

6. Iterate through the `goodAgainst` list of the hero to find matchups against the input hero.

7. If a matchup is found (indicated by the presence of `[heroName]:` in the string), extract the anti-hero's name and description.

8. Print information about the anti-hero, including their name, main attribute, roles, and the reason they are a counter.

9. Set `foundAntiHero` to `true` to indicate that a counter-hero was found and break the loop.

10. If no counter-hero is found, print a message indicating that there are no counter-heroes based on the inputs.

## Generating and Testing Recommendations

- Play Dota 2 and see if the suggested anti-hero works effectively against the given hero.
- Watch professional games to observe draft strategies and see how hero counters are used.
- If you are experienced in the game, evaluate the reasons provided by the system and assess their validity.
