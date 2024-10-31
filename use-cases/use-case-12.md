# USE CASE: 12 Produce a report with the top N populated cities in a region where N is provided by the user.
## CHARACTERISTIC INFORMATION

### Goal in Context

As an urban planner I want to see the top N populated cities in a region where N is provided by the user so I can focus my planning on the most populated cities in the region.

### Scope

Organisation

### Level

Primary task.

### Preconditions

Database contains up-to-date population data for the region.

### Success End Condition

A report is available for planner to study population data.

### Failed End Condition

No report is produced.

### Primary Actor

Urban Planner

### Trigger

Urban planner inputs N value

## MAIN SUCCESS SCENARIO

1. Analyst requests info on top N populated cities in region.
2. System accesses regions data from world database.
3. System sorts through results and produces data on top N populated cities.
4. System provides generated report.

## EXTENSIONS

3. Region doesnt exist:
   i. System informs urban planner region doesn't exist.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 5/02/2024 - Final code review
