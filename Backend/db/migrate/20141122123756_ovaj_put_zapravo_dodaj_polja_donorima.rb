class OvajPutZapravoDodajPoljaDonorima < ActiveRecord::Migration
  def change
  	add_column :donors, :first_name, :text
 	add_column :donors, :last_name, :text
 	add_column :donors, :push_reg_id, :text
 	add_column :donors, :locked, :boolean
 	add_column :donors, :note, :text
 	add_column :donors, :date_of_last_donation, :timestamp


  end
end
