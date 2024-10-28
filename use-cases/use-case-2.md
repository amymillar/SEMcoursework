# USE CASE: 2 Produce a report on all the countries in a region organised by largest population to smallest.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a population analyst I want to see all the countries in a region organised by largest population to smallest* so I can asses regional population trends.

### Scope

Organisation

### Level

Primary task.

### Preconditions

Database contains up-to-date population data for the region.

### Success End Condition

A report is available for analysts to study population sizes.

### Failed End Condition

No report is produced.

### Primary Actor

Population analysts

### Trigger

Analyst requests population information about the region.

## MAIN SUCCESS SCENARIO

1. Analyst request the information for the worlds population.
2. System accesses the world database.
3. System accesses regions data.
4. System sorts regions populations in descending order.
5. System provides a generated report to analyst.

## EXTENSIONS

*put here the extensions, one at a time, each referring to the step of the main scenario*

1. **Condition**: action of sub use case

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 5/02/2024 - Final code review
