/*예제 데이터 만들기*/
DECLARE
begin
    delete from board;
    for num in 1..100 loop
        insert into board (no, title, content, author)
        values(num, 'test', 'test', 'test');
    end loop;
    commit;
end;
/
SELECT
    *
FROM(
    SELECT
        /*+ INDEX_DESC(board BOARD_PK) */
        ROWNUM rn, no, title, content, author
    FROM
        board
    WHERE ROWNUM <= 1 * 10
    )
WHERE rn > (1 - 1 ) * 10;
SELECT
    /*+ INDEX_DESC(board BOARD_PK) */
    no, title, content, author
FROM
    board;
-- 인덱스 찾기
SELECT a.table_name 
     , a.index_name 
     , a.column_name 
  FROM all_ind_columns a 
 WHERE a.table_name = 'BOARD';