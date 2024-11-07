# USE CASE: 4 Produce a report with the top N populated countries in a region where N is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a population analyst I want to see the top N populated countries in a region where N is provided by the user to focus on specific population areas within regions.

### Scope

Organisation

### Level

Primary task

### Preconditions

Database contains up-to-date population data for the region.

### Success End Condition

A report is available for analysts to study population data.

### Failed End Condition

No report is produced.

### Primary Actor

Population Analyst

### Trigger

Analyst inputs N value

## MAIN SUCCESS SCENARIO

1. Analyst requests info on top N countries in region.
2. System captures regions data.
3. System sorts through results and produces data on top N populated countries in region.
4. System provides generated report to analyst.

## EXTENSIONS

3. Region doesnt exist: 
  i. System informs Analyst continent doesnt exist

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 5/02/2024 - Final code review
