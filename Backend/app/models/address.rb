class Address < ActiveRecord::Base

	belongs_to :donor
	belongs_to :institution
	
	
end
