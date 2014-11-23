json.array!(@blood_groups) do |blood_group|
  json.extract! blood_group, :id, :group
  json.url blood_group_url(blood_group, format: :json)
end
