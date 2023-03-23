package com.hosinsa.controller;

import com.cart.controller.action.CartDeleteAction;
import com.cart.controller.action.CartInAction;
import com.cart.controller.action.CartListAction;
import com.cart.controller.action.CartModifyAction;
import com.cart.controller.action.CartPurchaseAction;
import com.cart.controller.action.CartPurchaseCompleteAction;
import com.cart.controller.action.CartResetAction;
import com.hosinsa.controller.action.GoodsViewAction;
import com.hosinsa.controller.action.MainAction;
import com.member.controller.action.LoginAction;
import com.member.controller.action.LogoutAction;
import com.member.controller.action.MemberIdCheckAction;
import com.member.controller.action.MemberIdSearchAction;
import com.member.controller.action.MemberIntroducerCheckAction;
import com.member.controller.action.MemberJoinAction;
import com.member.controller.action.MemberJoinFormAction;
import com.member.controller.action.MemberListAction;
import com.member.controller.action.MemberListFormAction;
import com.member.controller.action.MemberManageAction;
import com.member.controller.action.MemberManageFormAction;
import com.member.controller.action.MemberViewAction;
import com.member.controller.action.OrderListAction;
import com.member.controller.action.UserCheckAction;
import com.member.controller.action.UserInfoUpdateAction;
import com.member.controller.action.UserInfoUpdateFromAction;
import com.member.controller.action.UserInfoViewAction;
import com.member.controller.action.UserPwCheckAction;
import com.member.controller.action.UserPwCheckFormAction;
import com.product.controller.action.ProductCategorySearchAction;
import com.product.controller.action.ProductDeleteAction;
import com.product.controller.action.ProductListAction;
import com.product.controller.action.ProductManageAction;
import com.product.controller.action.ProductPronumCheckAction;
import com.product.controller.action.ProductUpdateAction;
import com.product.controller.action.ProductUpdateFormAction;
import com.product.controller.action.ProductViewFormAction;
import com.product.controller.action.ProductWriteAction;
import com.product.controller.action.ProductWriteFormAction;

public class HosinsaActionFactory {
	private HosinsaActionFactory() {
	}
	
	private static HosinsaActionFactory instance = new HosinsaActionFactory();
	
	public static HosinsaActionFactory getInstance() {
		return instance;
	}
	
	public HosinsaAction getAction(String command) {
		HosinsaAction action = null;
		System.out.println("ActionFactory : "+command);
		
		if(command.equals("main")) {
			action = new MainAction();
		}
		else if(command.equals("login")) {
			action = new LoginAction();
		}
		else if(command.equals("user_check")) {
			action = new UserCheckAction();
		}
		else if(command.equals("logout")) {
			action = new LogoutAction();
		}
		else if(command.equals("goods_view")) {
			action = new GoodsViewAction();
		}
		else if(command.equals("member_join_form")) {
			action = new MemberJoinFormAction();
		}
		else if(command.equals("member_join")) {
			action = new MemberJoinAction();
		}
		else if(command.equals("member_id_check")) {
			action = new MemberIdCheckAction();
		}
		else if(command.equals("member_introducer_check")) {
			action = new MemberIntroducerCheckAction();
		}
		else if(command.equals("member_list_form")) {
			action = new MemberListFormAction();
		}
		else if(command.equals("member_list")) {
			action = new MemberListAction();
		}
		else if(command.equals("member_id_search")) {
			action = new MemberIdSearchAction();
		}
		else if(command.equals("member_view")) {
			action = new MemberViewAction();
		}
		else if(command.equals("member_manage_form")) {
			action = new MemberManageFormAction();
		}
		else if(command.equals("member_manage")) {
			action = new MemberManageAction();
		}
		else if(command.equals("user_info_view")) {
			action = new UserInfoViewAction();
		}
		else if(command.equals("user_pw_check_form")) {
			action = new UserPwCheckFormAction();
		}
		else if(command.equals("user_pw_check")) {
			action = new UserPwCheckAction();
		}
		else if(command.equals("user_info_update_form")) {
			action = new UserInfoUpdateFromAction();
		}
		else if(command.equals("user_info_update")) {
			action = new UserInfoUpdateAction();
		}
		else if(command.equals("product_list")) {
			action = new ProductListAction();
		}
		else if(command.equals("product_manage")) {
			action = new ProductManageAction();
		}
		else if(command.equals("product_category_search")) {
			action = new ProductCategorySearchAction();
		}
		else if(command.equals("product_view")) {
			action = new ProductViewFormAction();
		}
		else if(command.equals("product_update")) {
			action = new ProductUpdateFormAction();
		}
		else if(command.equals("product_write_form")) {
			action = new ProductWriteFormAction();
		}
		else if(command.equals("product_write")) {
			action = new ProductWriteAction();
		}
		else if(command.equals("product_delete")) {
			action = new ProductDeleteAction();
		}
		else if(command.equals("product_info_update")) {
			action = new ProductUpdateAction();
		}
		else if(command.equals("cart_list")) {
			action=new CartListAction();
		}
		else if(command.equals("purchase")) {
			action=new CartPurchaseAction();
		}
		else if(command.equals("purchase_complete")) {
			action=new CartPurchaseCompleteAction();
		}
		else if(command.equals("modify_quantity")) {
			action=new CartModifyAction();
		}
		else if(command.equals("delete_item")) {
			action=new CartDeleteAction();
		}
		else if(command.equals("reset_cart")) {
			action=new CartResetAction();
		}
		else if(command.equals("cart_in")) {
			action=new CartInAction();
		}
		else if(command.equals("order_list")) {
			action=new OrderListAction();
		}
		else if(command.equals("product_pronum_check")) {
			action=new ProductPronumCheckAction();
		}
		return action;
	}  
}
