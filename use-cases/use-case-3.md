# USE CASE: 3 Produce a report on all the countries in a continent organised by largest population to smallest.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a population analyst I want to see all the countries in a continent organised by largest population to smallest so I can asses population trends within continents.

### Scope

Organisation

### Level

Primary task

### Preconditions

Database contains up-to-date population data for the continent

### Success End Condition

A report is available for analysts to study population sizes.

### Failed End Condition

No report is produced.

### Primary Actor

Population Analyst

### Trigger

Analyst requests population information about the countries in a continent

## MAIN SUCCESS SCENARIO

1. Analyst request the information for a regions population.
2. System accesses continents data from world database.
3. System sorts the continents population in descending order.
4. System provides a generated report to analyst.

## EXTENSIONS

3. Continent doesn't exist:
   i. System informs Analyst continent doesnt exist

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 5/02/2024 - Final code review

