WITH traffic AS (
    SELECT *,
           LAG(people, 1) OVER (ORDER BY id) AS prev_people,
           LAG(people, 2) OVER (ORDER BY id) AS prev2_people,
           LEAD(people, 1) OVER (ORDER BY id) AS next_people,
           LEAD(people, 2) OVER (ORDER BY id) AS next2_people
    FROM Stadium
)
SELECT id, visit_date, people
FROM traffic
WHERE
      (
          people >= 100
          AND prev_people >= 100
          AND prev2_people >= 100
      )
   OR (
          people >= 100
          AND prev_people >= 100
          AND next_people >= 100
      )
   OR (
          people >= 100
          AND next_people >= 100
          AND next2_people >= 100
      )
ORDER BY id;