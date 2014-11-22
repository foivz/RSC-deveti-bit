class PopraviKrvneGrupe < ActiveRecord::Migration
  def change
  	add_column :blood_groups, :group, :text
  end
end
