Rails.application.routes.draw do
  resources :donations  
  resources :donors, except: :show
  resources :blood_groups
  

  devise_for :donors
  devise_for :institutions
  devise_for :super_admins
  resources :pages

  resources :institutions, except: :show #mozda treba prebaciti ispod resources :donors, except: :show
  


  #RUTE ZA DONACIJE
  get 'donacije' => 'donations#index'
  get 'dodaj' => 'donations#new'
  
  get 'donor/:id' => 'donors#show'
  get 'donors/:id' => 'donors#show'
  get 'donori' => 'donors#index'

  get 'statistika' => 'pages#stats'
  get 'pregled' => 'donors#index'
  get 'institucije/:id' => 'institutions#show'


  as :super_admin do
    get "super_admin_login", to: "devise/sessions#new"
    get '123', to: 'devise/registrations#new'
  end

  as :institution do
    get "login", to: "devise/sessions#new"
    get "logout", to: "devise/sessions#destroy"
    get 'registracija', to: 'devise/registrations#new'
  end

  as :donor do
    get 'login2', to: "devise/sessions#new"  
    get "logout2", to: "devise/sessions#destroy"
    get 'registracija2', to: 'devise/registrations#new'  
  end
  
  root 'pages#index'


  # The priority is based upon order of creation: first created -> highest priority.
  # See how all your routes lay out with "rake routes".

  # You can have the root of your site routed with "root"
  # root 'welcome#index'

  # Example of regular route:
  #   get 'products/:id' => 'catalog#view'

  # Example of named route that can be invoked with purchase_url(id: product.id)
  #   get 'products/:id/purchase' => 'catalog#purchase', as: :purchase

  # Example resource route (maps HTTP verbs to controller actions automatically):
  #   resources :products

  # Example resource route with options:
  #   resources :products do
  #     member do
  #       get 'short'
  #       post 'toggle'
  #     end
  #
  #     collection do
  #       get 'sold'
  #     end
  #   end

  # Example resource route with sub-resources:
  #   resources :products do
  #     resources :comments, :sales
  #     resource :seller
  #   end

  # Example resource route with more complex sub-resources:
  #   resources :products do
  #     resources :comments
  #     resources :sales do
  #       get 'recent', on: :collection
  #     end
  #   end

  # Example resource route with concerns:
  #   concern :toggleable do
  #     post 'toggle'
  #   end
  #   resources :posts, concerns: :toggleable
  #   resources :photos, concerns: :toggleable

  # Example resource route within a namespace:
  #   namespace :admin do
  #     # Directs /admin/products/* to Admin::ProductsController
  #     # (app/controllers/admin/products_controller.rb)
  #     resources :products
  #   end
end
