json.array!(@donations) do |donation|
  json.extract! donation, :id, :time, :notes
  json.url donation_url(donation, format: :json)
end
