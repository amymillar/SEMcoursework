# USE CASE: 8 Produce a report with all the cities in a country organised by largest population to smallest.

## CHARACTERISTIC INFORMATION

### Goal in Context

As an urban planner I want to see the cities in a country organised by largest population to smallest so I can see the most popular areas in cities.

### Scope

Organisation

### Level

Primary task.

### Preconditions

Database contains up-to-date population data for the country.

### Success End Condition

A report is available for planner to study population data.

### Failed End Condition

No report is produced.

### Primary Actor

Urban Planner

### Trigger

Urban Planner requests population data on countries cities.

## MAIN SUCCESS SCENARIO

1. Analyst request the information for population per city in a country.
2. System accesses countries data from world database.
3. System sorts the countries populations in descending order by city.
4. System provides a generated report to analyst.

## EXTENSIONS

3. Country doesn't exist:
   i. System informs urban planner country doesn't exist.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 5/02/2024 - Final code review
