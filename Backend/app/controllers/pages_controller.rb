class PagesController < ApplicationController
  before_action :set_page, only: [:show, :edit, :update, :destroy]

  respond_to :html

  def index

    @count = Donation.all.count
    @liters = (@count * 0.4).round(2)

    respond_with(@pages)
  end

  def stats
        @count = Donation.all.count
        @liters = (@count * 0.4).round(2)


  end

  def show
    respond_with(@page)
  end

  def new
    @page = Page.new
    respond_with(@page)
  end

  def edit
  end

  def create
    @page = Page.new(page_params)
    @page.save
    respond_with(@page)
  end

  def update
    @page.update(page_params)
    respond_with(@page)
  end

  def destroy
    @page.destroy
    respond_with(@page)
  end

  private
    def set_page
      @page = Page.find(params[:id])
    end

    def page_params
      params.require(:page).permit(:index, :about, :help)
    end
end
