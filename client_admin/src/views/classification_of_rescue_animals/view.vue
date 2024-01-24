<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','category_of_animal_rescue') || $check_field('add','category_of_animal_rescue') || $check_field('set','category_of_animal_rescue')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="救助动物类别" prop="category_of_animal_rescue">
												<el-input id="category_of_animal_rescue" v-model="form['category_of_animal_rescue']" placeholder="请输入救助动物类别"
							  v-if="user_group === '管理员' || (form['classification_of_rescue_animals_id'] && $check_field('set','category_of_animal_rescue')) || (!form['classification_of_rescue_animals_id'] && $check_field('add','category_of_animal_rescue'))" :disabled="disabledObj['category_of_animal_rescue_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','category_of_animal_rescue')">{{form['category_of_animal_rescue']}}</div>
											</el-form-item>
			</el-col>
					
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "classification_of_rescue_animals_id",
				url_add: "~/api/classification_of_rescue_animals/add?",
				url_set: "~/api/classification_of_rescue_animals/set?",
				url_get_obj: "~/api/classification_of_rescue_animals/get_obj?",
				url_upload: "~/api/classification_of_rescue_animals/upload?",

				query: {
					"classification_of_rescue_animals_id": 0,
				},

				form: {
								"category_of_animal_rescue":  '', // 救助动物类别
											"classification_of_rescue_animals_id": 0, // ID
					
				},
				disabledObj:{
								"category_of_animal_rescue_isDisabled": false,
										},

	
	
			}
		},
		methods: {


	
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
										
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
						$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


			

			},


			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/classification_of_rescue_animals/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/classification_of_rescue_animals/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/classification_of_rescue_animals/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/classification_of_rescue_animals/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/classification_of_rescue_animals/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},


		},
		created() {
				},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
