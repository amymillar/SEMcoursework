# USE CASE: 5 Produce a report with the top N populated countries in a continent where N is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a population analyst I want to see the top N populated countries in a continent where N is provided by the user so I can focus on specific population hotspots within continents.

### Scope

Organisation

### Level

Primary task.

### Preconditions

Database contains up-to-date population data for the continent.

### Success End Condition

A report is available for analysts to study population sizes.

### Failed End Condition

No report is produced

### Primary Actor

Population Analyst

### Trigger

Analyst inputs N value

## MAIN SUCCESS SCENARIO

1. Analyst requests info on top N countries in region.
2. System captures continents data.
3. System sorts through results and produces data on top N populated countries in region.
4. System provides generated report to analyst.

## EXTENSIONS

3. Continent doesn't exist:
   i. System informs Analyst continent doesn't exist.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 5/02/2024 - Final code review
