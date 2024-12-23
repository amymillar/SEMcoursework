# USE CASE: 18 Produce a report with all the capital cities in a continent organised by largest population to smallest.

## CHARACTERISTIC INFORMATION

### Goal in Context

As an urban planner I want to see all the capital cities in a continent organised by largest population to smallest so I know where to focus my attention when planning.

### Scope

Organisation

### Level

Primary task.

### Preconditions

Database contains up-to-date population data for the world.

### Success End Condition

A report is available for urban planner to study population data.

### Failed End Condition

No report is produced.

### Primary Actor

Urban Planner

### Trigger

Urban Planner requests report on capital cities in a continent organised by largest population to smallest.

## MAIN SUCCESS SCENARIO

1. Urban Planner requests info on capital cities in a continent organised from largest population to smallest.
2. System accesses continents data from world database.
3. System sorts through results and organises data by population.
4. System provides generated report.

## EXTENSIONS

3. Continent doesn't exist:
   i. System informs urban planner continent doesn't exist.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 5/02/2024 - Final code review
