json.array!(@donors) do |donor|
  json.extract! donor, :id, :first_name, :last_name, :email, :push_reg_id, :locked, :note, :date_of_last_donation
  json.url donor_url(donor, format: :json)
end
