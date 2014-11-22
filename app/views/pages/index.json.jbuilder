json.array!(@pages) do |page|
  json.extract! page, :id, :index, :about, :help
  json.url page_url(page, format: :json)
end
