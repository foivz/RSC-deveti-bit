class BloodGroup < ActiveRecord::Base
	belongs_to :donor
	belongs_to :donation
end
