class SrediNekaPolja < ActiveRecord::Migration
  def change
  	add_column :donors, :gender, :integer
  	add_column :donors, :dob, :date
  	remove_column :donations, :time
  	add_column :addresses, :city, :text
  	add_column :addresses, :state, :text


  end
end
