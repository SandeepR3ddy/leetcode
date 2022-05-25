SELECT
    t.id,
    IF(ISNULL(t.p_id),
        'Root',
        IF(t.id IN (SELECT p_id FROM tree), 'Inner','Leaf')) as type
FROM tree t
ORDER BY t.id