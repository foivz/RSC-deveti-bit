class CreateDonations < ActiveRecord::Migration
  def change
    create_table :donations do |t|
      t.timestamp :time
      t.text :notes

      t.timestamps
    end
  end
end
