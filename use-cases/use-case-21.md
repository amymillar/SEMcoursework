# USE CASE: 21 Produce a report with the top N populated capital cities in a continent where N is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context

As an urban planner I want to see the top N populated capital cities in a continent where N is provided by the user to help my planning on specific continents capital cities.

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

Urban Planner enters N value.

## MAIN SUCCESS SCENARIO

1. Urban Planner requests info on top N populated capital cities in a continent.
2. System accesses world database.
3. System sorts through results and produces data on top N populated capital cities.
4. System provides generated report.


## EXTENSIONS

1. Input(N) is invalid:
   i. System requests user for valid input.
3. Continents doesn't exist:
   i. System informs user continent doesn't exist.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 5/02/2024 - Final code review
