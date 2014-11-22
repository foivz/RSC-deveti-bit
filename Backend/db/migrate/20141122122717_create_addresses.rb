class CreateAddresses < ActiveRecord::Migration
  def change
    create_table :addresses do |t|
      t.decimal :long
      t.decimal :lat
      t.text :address

      t.timestamps
    end
  end
end
