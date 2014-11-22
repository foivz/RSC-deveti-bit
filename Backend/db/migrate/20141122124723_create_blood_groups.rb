class CreateBloodGroups < ActiveRecord::Migration
  def change
    create_table :blood_groups do |t|

      t.timestamps
    end
  end
end
