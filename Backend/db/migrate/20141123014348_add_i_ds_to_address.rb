class AddIDsToAddress < ActiveRecord::Migration
  def change
  	 add_column :addresses, :donor_id, :integer
  	 add_column :addresses, :institution_id, :integer

  end
end
