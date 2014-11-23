namespace :db do
  desc "TODO"
  task populate: :environment do

  	a = ['A+', 'A-', 'B+', 'B-', 'AB+', 'AB-', '0+', '0-']
  	a.each {|x| BloodGroup.create(group: x) }
  	

  end

end
