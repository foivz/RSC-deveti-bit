class Donation < ActiveRecord::Base
	belongs_to :donor

	has_one :blood_group
	has_one :institution
end
