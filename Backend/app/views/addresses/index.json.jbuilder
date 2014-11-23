json.array!(@addresses) do |address|
  json.extract! address, :id, :long, :lat, :city, :state
  json.url address_url(address, format: :json)
end
