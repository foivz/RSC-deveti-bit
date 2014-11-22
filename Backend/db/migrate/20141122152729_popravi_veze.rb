class PopraviVeze < ActiveRecord::Migration
  def change
  	add_column :donations, :user_id, :integer
  	add_column :donations, :institution_id, :integer
  	add_column :donations, :blood_group_id, :integer
  end
end
