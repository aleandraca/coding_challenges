-- https://app.codility.com/programmers/trainings/6/sql_events_delta/
-- Easy | SqlEventsDelta | PostgreSQL | 100%
SELECT
    win.event_type,
    win.diff
FROM (
    SELECT event_type,
        value - LEAD(value) OVER (
            PARTITION BY event_type
            ORDER BY time DESC
        ) AS diff,
        row_number() OVER (
            PARTITION BY event_type
            ORDER BY time DESC
        ) AS row_num
    FROM events
) AS win
WHERE win.row_num = 1
    AND win.diff IS NOT NULL
