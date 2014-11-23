json.array!(@institutions) do |institution|
  json.extract! institution, :id, :name, :low_level
  json.url institution_url(institution, format: :json)
end
