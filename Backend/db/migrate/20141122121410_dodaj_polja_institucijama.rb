class DodajPoljaInstitucijama < ActiveRecord::Migration
  def change
  	add_column :institutions, :name, :text
  	add_column :institutions, :mail, :text
  	add_column :institutions, :low_level, :integer
  	add_column :institutions, :locked, :bool

  end
end
