json.array!(@donations) do |donation|
  json.extract! donation, :id, :time, :notes, :user_id, :institution_id, :blood_group_id
  json.url donation_url(donation, format: :json)
end
