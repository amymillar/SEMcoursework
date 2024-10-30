# USE CASE: 24 Produce a report with the population of people, people living in cities, and people not living in cities in each country.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a development advisor I want to see the population living in cities, and people not living in cities in each country so I can asses the differences in urban and rural populations in each country.

### Scope

Organisation

### Level

Primary task.

### Preconditions

Database contains up-to-date population data for the world.

### Success End Condition

A report is available for development advisor to study population data.

### Failed End Condition

No report is produced.

### Primary Actor

Development Advisor

### Trigger

Development advisor requests database to produce a report on populations of people, people living in and not living in cities in a country.

## MAIN SUCCESS SCENARIO

1. Development advisor requests report on populations of people in a country.
2. System captures country name.
3. System extracts populations of people, people living in and out of cities in country.
4. System produces report.

## EXTENSIONS

3. **Continent doesnt exist:**
   i. System informs development advisor continent doesnt exist.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 5/02/2024 - Final code review
