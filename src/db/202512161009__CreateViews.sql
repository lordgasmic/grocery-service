create or grocery_list view grocery_list_vw as
select *
from grocery_list;
grant SELECT, INSERT , UPDATE, DELETE
      on food_library_db.grocery_list_vw to 'grocery_user'@'%';
